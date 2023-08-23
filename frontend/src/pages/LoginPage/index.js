import React, { useState } from 'react'
import { styled } from 'styled-components'
import axios from '../../api/axios'

const LoginPage = () => {

    const [userId, setUserId] = useState("");
    const [password, setPassword] = useState("");

    const userIdHandler = (e) => {
        setUserId(e.target.value);
    }

    const passwordHandler = (e) => {
        setPassword(e.target.value);
    }

    const signInUser = async () => {
        const userInfo = {
            "userId": userId,
            "password": password
        }

        console.log('userInfo: ', userInfo);

        await axios.post('/user-service/users/signin', userInfo)
        .then(res => console.log('로그인성공', res))
        .catch(error => error.response.data);
    }

    return (
        <Container>
            <PageTitle>
                Log In Page
            </PageTitle>
            <InputForm>
                <InputUserId onChange={userIdHandler} type="text"></InputUserId>
                <InputPassword onChange={passwordHandler} type="password"></InputPassword>
                <LoginButton type="button" onClick={signInUser}>Log In</LoginButton>
            </InputForm>
        </Container>
    )
}

export default LoginPage

const Container = styled.section`
overflow: hidden;
display: flex;
flex-direction: column;
text-align: center;
height: 100vh;
`;

const PageTitle = styled.div``;

const InputForm = styled.form`
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
`;

const InputUserId = styled.input``;

const InputPassword = styled.input``;

const LoginButton = styled.button``;

