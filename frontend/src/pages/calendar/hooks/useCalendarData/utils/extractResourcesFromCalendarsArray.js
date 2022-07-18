import { updateResourcesFromConflicts } from './updateResourcesFromConflicts';

export const extractResourcesFromCalendarsArray = ({
  calendarsArray,
  entries,
  conflicts,
}) => {
  if (!calendarsArray) {
    return [];
  }

  const resourcesById = calendarsArray
    .flatMap((calendar) => calendar.resources)
    .reduce((accum, resource) => {
      accum[resource.id] = resource;
      return accum;
    }, {});

  let resources = Object.values(resourcesById);

  // IMPORTANT: completely remove 'parentId' property if it's not found in our list of resources
  // Else fullcalendar.io won't render that resource at all.
  resources.forEach((resource) => {
    if ('parentId' in resource && !resourcesById[resource.parentId]) {
      console.log('removing parentId because was not found: ', resource);
      delete resource.parentId;
    }
  });
  //console.log('extractResourcesFromCalendarsArray', resources);

  resources = updateResourcesFromConflicts({ resources, conflicts, entries });

  return resources;
};
