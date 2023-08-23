import React, { useEffect, useState } from 'react'

const MainPage = () => {
    const [searchId, setSearchId] = useState(0);
    
    useEffect(() => {
    })
    
    const handleChange = (e) => {
        setSearchId(e.target.value);
    }

  return (
    <div>
        <h1>Main Page입니다.</h1>
        <input 
            onChange={handleChange}
            className='nav__input' type="text" placeholder="검색해주세요."/>
        <button>검색</button>
    </div>
  )
}

export default MainPage
