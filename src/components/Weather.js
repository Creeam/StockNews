import React from "react";
import Styles from './style.css';

class Weather extends React.Component {
	render() {
		return(
			<div id={this.props.id}>
				{this.props.text};
			</div>
		);
	}
}

export default Weather;