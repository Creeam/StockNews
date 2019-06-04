import React from "react";
import Styles from './style.css';

class Navigation extends React.Component {
	render() {
		return(
			<nav>
				<div id="menuShow"><i className="fa fa-bars" aria-hiddeb="true"></i></div>
				<div id="hideMenu">
					<a href="#">Политика</a>
					<a href="#">Экономика</a>
					<a href="#">Технологии</a>
					<a href="#">Искусство</a>
					<a href="#">Еда</a>
					<a href="#">Кино</a>
					<a href="#">Музыка</a>
				</div>
				<div id="mobileMenu">
					<a href="#">Политика</a><br />
					<a href="#">Экономика</a><br />
					<a href="#">Технологии</a><br />
					<a href="#">Искусство</a><br />
					<a href="#">Еда</a><br />
					<a href="#">Музыка</a><br />
					<hr />
					<a href="#">Войти</a>
					<a href="#">Регистрация</a>
				</div>
			</nav>
		);
	}
}

export default Navigation;