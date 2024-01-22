import React from 'react';
import ReactDOM from 'react-dom';
import './Assets/Styles/index.css';
import App from './App';
import registerServiceWorker, { unregister } from './registerServiceWorker';
import { AuthLogin } from './AuthComponents/AuthLogin';

ReactDOM.render(
  <AuthLogin>
    <App />
  </AuthLogin>
  , document.getElementById('root'));
// registerServiceWorker(); // commented out manually since don't need it as offline

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
unregister();