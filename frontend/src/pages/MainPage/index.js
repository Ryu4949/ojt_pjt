import React, { useEffect, useState } from 'react'
import axios from '../../api/axios';
import requests from '../../api/requests';

const MainPage = () => {
    const [searchId, setSearchId] = useState(0);
    const [userInfo, setUserInfo] = useState({});

    // api 연결 확인용입니다.

    useEffect(() => {
        if(searchId > 0) {
            getUserDetail(searchId)
        }
    })
    
    const handleChange = (e) => {
        setSearchId(e.target.value);
    }

    const getUserDetail = async (userId) => {
        try {
            const response = await axios.get(`/user-service/users/${userId}`);
            console.log(response);
            setUserInfo(response.data);
            console.log('userInfo: ', userInfo);
        } catch(error) {
            console.log(error);
        }
    }

  return (
    <div>
        <h1>Main Page입니다.</h1>
        <input 
            onChange={handleChange}
            className='nav__input' type="text" placeholder="검색해주세요."/>
    </div>
  )
}

export default MainPage
