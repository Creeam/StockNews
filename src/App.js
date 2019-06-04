import React from "react";
import Header from "./components/Header";
import Navigation from "./components/Navigation";
import MainPage from "./components/MainPage";
import RightBlock from './components/RightBlock';

class App extends React.Component {
  render() {
    return (
      <div>
      	<Header id="head"/>
        <Navigation />
        <MainPage id="main"/>
        <RightBlock id="courses" title="Заголовок" />
   
      </div>
    );
  }
}

export default App;