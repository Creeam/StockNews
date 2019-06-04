import React from "react";
import Styles from './style.css';

class Button extends React.Component {
	render() { 
		return (
			<a href={this.props.href} title={this.props.title}>
				<div class={this.props.className}>{this.props.buttonName}</div>
			</a>
		);
	}
}

export default Button;