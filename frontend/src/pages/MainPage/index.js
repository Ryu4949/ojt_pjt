import React, { useEffect, useState } from 'react'
import axios from '../../api/axios';
import requests from '../../api/requests';
import { useDebounce } from '../../hooks/useDebounce';

const MainPage = () => {
    const [searchId, setSearchId] = useState(0);
    const [userInfo, setUserInfo] = useState({});
    const debouncedSearchId = useDebounce(searchId, 500);

    // api 연결 확인용입니다.

    useEffect(() => {
        if(searchId > 0) {
            getUserDetail(debouncedSearchId)
        }
    }, [debouncedSearchId])
    
    const handleChange = (e) => {
        setSearchId(e.target.value);
    }

    const getUserDetail = async (userId) => {
        try {
            await axios.get(`/user-service/users/${userId}`)
            .then((res) => setUserInfo(res.data))
            .then(console.log('userInfo: ', userInfo));

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
        <div>
            { userInfo ? userInfo.name : "조회된 결과가 없습니다." }
        </div>
    </div>
  )
}

export default MainPage
