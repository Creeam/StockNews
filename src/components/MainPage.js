import React from "react";
import Styles from './main_page.css';
import Elements from './Elements';

class MainPage extends React.Component {

	render() {

		return(
			<div id={this.props.id}>
				<div id="news">
					<h2 className="heading"><span>Главные</span> новости</h2>

					<div style={{clear: 'both'}}><br /></div>

					<Elements />
					<Elements />
					<Elements />
					<Elements />
					<Elements />
					<Elements />
					<Elements />
					<Elements />

				</div>
			</div>
		);
	}
}

export default MainPage;