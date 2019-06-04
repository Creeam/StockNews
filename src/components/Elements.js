import React from 'react';
import './style.css';
import './main_page.css';

export default class Elements extends React.Component {

	render() {
		return (
				<div className="article">
					<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFAvQ453iL40e8SsoBaXUzzuEzOn6dcphGVwAQhfdS4Zke5Xv7" alt="Image"/>
					<span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam tempore, dicta ad saepe quis unde.</span>
					<a href="#" title="Вход">
					<div className="btn">Читать</div>
					</a>
				</div>
				);
	}
}