import React, { useEffect } from 'react'
import { useSelector } from 'react-redux';
import { Navigate, useLocation, useNavigate } from 'react-router-dom';
import { styled } from 'styled-components';

const Nav = () => {
    const initialUserData = localStorage.getItem('userData') ?
    JSON.parse(localStorage.getItem('userData')) : {};

    const user = useSelector(state => state.user);
    const { pathname } = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
        if(user) {
            if(pathname === "/") {
                navigate("/main");
            }
        } else {
            navigate("/");
        }
    }, [user, navigate, pathname])


    return (
        <NavWrapper>

        </NavWrapper>
    )
}

export default Nav

const NavWrapper = styled.nav`
  position: sticky;
  top: 0;
  left: 0;
  right: 0;
  height: 70px;
  background-color: #090b13;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 36px;
  letter-spacing: 16px;
  z-index: 3;
  `;