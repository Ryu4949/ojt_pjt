import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { Navigate, useLocation, useNavigate } from 'react-router-dom';
import { styled } from 'styled-components';
import { removeUser } from '../store/userSlice';

const Nav = () => {
    const initialUserData = localStorage.getItem('userData') ?
    JSON.parse(localStorage.getItem('userData')) : {};

    const user = useSelector(state => state.user);
    const { pathname } = useLocation();
    const navigate = useNavigate();
    const dispatch = useDispatch();

    useEffect(() => {
        if(user.name) {
            if(pathname === "/") {
                navigate("/main");
            }
        } else {
            navigate("/");
        }
    }, [user, navigate, pathname])

    const handleSignOut = () => {
        dispatch(removeUser());
        console.log(user);
        localStorage.removeItem("userData");
        navigate('/');
    };


    return (
        <NavWrapper>
            <Logo>
                <img src="/src/logo.svg" alt="project_logo" />
            </Logo>

            {pathname === "/" ?
            '' :
            <SignOut>
              <DropDown>
                  <span onClick={handleSignOut}>Sign Out</span>
              </DropDown>
            </SignOut>}
        </NavWrapper>
    )
}

export default Nav

const DropDown = styled.div`
  position: absolute;
  top: 48px;
  right: 0px;
  background: yellow;
  border: 1px solid rgba(151, 151, 151, 0.34);
  border-radius: 4px;
  box-shadow: rgb(0 0 0 /50%) 0px 0px 18px 0px;
  padding: 10px;
  font-size: 14px;
  letter-spacing: 3px;
  width: 100%;
  opacity: 0;
`;

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

  const Logo = styled.a`
  padding: 0;
  width: 80px;
  margin-top: 4px;
  max-height: 70px;
  font-size: 0;
  display: inline-block;
  
  img {
    display: block;
    width: 100%;
  }`;

  const SignOut = styled.div`
  position: relative;
  height: 48px;
  width: 48px;
  display: flex;
  cursor: pointer;
  align-items: center;
  justify-content: center;
  background-color: white;

  &:hover {
    ${DropDown} {
      opacity: 1;
      transition-duration: 1s;
    }
  }
`;