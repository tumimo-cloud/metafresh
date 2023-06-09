package org.adempiere.ad.validationRule;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import lombok.EqualsAndHashCode;
import org.compiere.util.NamePair;

import javax.annotation.Nullable;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2016 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

/**
 * Static utility methods for {@link INamePairPredicate}s.
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public final class NamePairPredicates
{
	private NamePairPredicates()
	{
		throw new IllegalStateException();
	}

	public static final INamePairPredicate ACCEPT_ALL = new INamePairPredicate()
	{
		@Override
		public String toString()
		{
			return "ACCEPT_ALL";
		}

		@Override
		public Set<String> getParameters(@Nullable final String contextTableName)
		{
			return ImmutableSet.of();
		}

		@Override
		public boolean accept(final IValidationContext evalCtx, final NamePair item)
		{
			return true;
		}
	};

	public static Composer compose()
	{
		return new Composer();
	}

	@EqualsAndHashCode
	private static final class ComposedNamePairPredicate implements INamePairPredicate
	{
		private final ImmutableSet<INamePairPredicate> predicates;

		private ComposedNamePairPredicate(final Set<INamePairPredicate> predicates)
		{
			// NOTE: we assume the predicates set is: not empty, has more than one element, does not contain nulls
			this.predicates = ImmutableSet.copyOf(predicates);
		}

		@Override
		public String toString()
		{
			return MoreObjects.toStringHelper("composite")
					.addValue(predicates)
					.toString();
		}

		@Override
		public ImmutableSet<String> getParameters(@Nullable final String contextTableName)
		{
			return predicates.stream()
						.flatMap(predicate -> predicate.getParameters(contextTableName).stream())
						.collect(ImmutableSet.toImmutableSet());
		}

		@Override
		public boolean accept(final IValidationContext evalCtx, final NamePair item)
		{
			for (final INamePairPredicate predicate : predicates)
			{
				if (predicate.accept(evalCtx, item))
				{
					return true;
				}
			}

			return false;
		}
	}

	public static class Composer
	{
		private Set<INamePairPredicate> collectedPredicates = null;

		private Composer()
		{
			super();
		}

		public INamePairPredicate build()
		{
			if (collectedPredicates == null || collectedPredicates.isEmpty())
			{
				return ACCEPT_ALL;
			}
			else if (collectedPredicates.size() == 1)
			{
				return collectedPredicates.iterator().next();
			}
			else
			{
				return new ComposedNamePairPredicate(collectedPredicates);
			}
		}

		public Composer add(@Nullable final INamePairPredicate predicate)
		{
			if (predicate == null || predicate == ACCEPT_ALL)
			{
				return this;
			}

			if (collectedPredicates == null)
			{
				collectedPredicates = new LinkedHashSet<>();
			}

			if (collectedPredicates.contains(predicate))
			{
				return this;
			}

			collectedPredicates.add(predicate);
			return this;
		}
	}
}
