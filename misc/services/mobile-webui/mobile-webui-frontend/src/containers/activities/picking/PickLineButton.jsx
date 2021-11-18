import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';
import counterpart from 'counterpart';

import LineButton from '../common/LineButton';
import ButtonWithIndicator from '../../../components/ButtonWithIndicator';
import ButtonQuantityProp from '../../../components/ButtonQuantityProp';
import { pushHeaderEntry } from '../../../actions/HeaderActions';

class PickLineButton extends PureComponent {
  handleClick = () => {
    const { dispatch, caption, onHandleClick } = this.props;

    onHandleClick();
    dispatch(
      pushHeaderEntry({
        location,
        values: [
          {
            caption: counterpart.translate('activities.picking.PickingLine'),
            value: caption,
            bold: true,
          },
        ],
      })
    );
  };

  render() {
    const { caption, uom, qtyPicked, qtyToPick, completeStatus, appId } = this.props;

    return (
      <>
        <ButtonWithIndicator caption={caption} completeStatus={completeStatus}>
          <ButtonQuantityProp qtyCurrent={qtyPicked} qtyTarget={qtyToPick} uom={uom} appId={appId} />
        </ButtonWithIndicator>
      </>
    );
  }
}

PickLineButton.propTypes = {
  //
  // Props
  wfProcessId: PropTypes.string.isRequired,
  activityId: PropTypes.string.isRequired,
  lineId: PropTypes.string.isRequired,
  caption: PropTypes.string.isRequired,
  isUserEditable: PropTypes.bool.isRequired,
  completeStatus: PropTypes.string.isRequired,
  uom: PropTypes.string.isRequired,
  qtyPicked: PropTypes.number.isRequired,
  qtyToPick: PropTypes.number.isRequired,
  appId: PropTypes.string.isRequired,
  onHandleClick: PropTypes.func.isRequired,
  //
  // Actions
  dispatch: PropTypes.func.isRequired,
};

export default LineButton(PickLineButton);