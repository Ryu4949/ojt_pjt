import React, { useEffect, useState } from 'react'
import axios from '../../api/axios';
import requests from '../../api/requests';

const MainPage = () => {
    const [searchId, setSearchId] = useState(0);

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
        <button onClick={getUserDetail}>검색</button>
    </div>
  )
}

export default MainPage
