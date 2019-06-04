import React from "react";
import Logo from "./Logo";
import Weather from "./Weather";
import Button from "./Button";

class Header extends React.Component {
	render() {
		return(
			<header id={this.props.id}>
				<Logo id="logo" href="#" title="Главная" text="StockNews"/>
				<Weather id="weather" text="Минск +20, облачно"/>
				<Button href="#" title="Вход" className="btn" buttonName="Войти"/>
				<Button href="#" title="Регистрация на сайте" className="btn" buttonName="Регистрация"/>
			</header>
		);
	}
}

export default Header;