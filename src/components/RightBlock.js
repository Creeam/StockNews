import React from "react";

export default class RightBlock extends React.Component {
	render() {
		return(
			<aside>
				<div id={this.props.id}>
					<h2 class="heading">{this.props.title}</h2>
					<div style={{clear: "both"}}><br /></div>
				</div>
			</aside>	
		);
	}
}