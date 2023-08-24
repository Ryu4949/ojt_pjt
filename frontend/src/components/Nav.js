import React from 'react'
import { styled } from 'styled-components';

const Nav = () => {
    const initialUserData = localStorage.getItem('userData') ?
    JSON.parse(localStorage.getItem('userData')) : {};

    return (
        <NavWrapper>
            
        </NavWrapper>
    )
}

export default Nav

const NavWrapper = styled.nav`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  height: 70px;
  background-color: "#090b13";
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 36px;
  letter-spacing: 16px;
  z-index: 3;
  `;