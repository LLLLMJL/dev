import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { KhComponent, KhComponent2, KhComponentAll } from './App';   //KhComponent들 2개다 동일한 './App' 파일안에 존재하므로 이렇게 사용가능
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <KhComponentAll />
    <KhComponentAll />
    <KhComponentAll />
    <KhComponentAll />
    <KhComponentAll />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
