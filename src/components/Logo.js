import React from "react";
import Styles from './style.css';

class Logo extends React.Component {
	render() {
		return(
			<div id={this.props.id}>
				<a href={this.props.href} title={this.props.title}>
					<span >{this.props.text}</span>
				</a>
			</div>
		);
	}
}

export default Logo;