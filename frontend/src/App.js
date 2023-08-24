import { Outlet, Route, Routes } from 'react-router-dom';
import './App.css';
import Nav from './components/Nav';
import LoginPage from './pages/LoginPage';
import MainPage from './pages/MainPage';
import SignupPage from './pages/SignupPage';

const Layout = () => {
  return (
    <div>
      <Nav />

      <Outlet />
    </div>
  )
}

const App = () => {
  return (
    <div className='app'>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<LoginPage />} />
          <Route path="main" element={<MainPage />}/>
          <Route path="signup" element={<SignupPage />}/>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
