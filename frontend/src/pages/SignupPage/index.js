import React, { useState } from 'react'
import { styled } from 'styled-components'
import axios from '../../api/axios'

const SignupPage = () => {

    const handleChange = 0;

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [userId, setUserId] = useState("");
    const [password, setPassword] = useState("");
    const [passwordConfirm, setPasswordConfirm] = useState("");
    const [department, setDepartment] = useState("");
    const [rank, setRank] = useState("");

    const nameHandler = (e) => {
        setName(e.target.value);
    }

    const emailHandler = (e) => {
        setEmail(e.target.value);
    }

    const userIdHandler = (e) => {
        setUserId(e.target.value);
    }

    const passwordHandler = (e) => {
        setPassword(e.target.value);
    }

    const passwordConfirmHandler = (e) => {
        setPasswordConfirm(e.target.value);
    }

    const departmentHandler = (e) => {
        setDepartment(e.target.value);
    }

    const rankHandler = (e) => {
        setRank(e.target.value);
    }

    const signupUser = () => {
        const signupInfo = {
            "name": name,
            "email": email,
            "userId": userId,
            "password": password,
            "department": department,
            "rankName": rank
        };

        console.log(signupInfo);

        axios.post('/user-service/users/', signupInfo)
        .then(res => console.log(res))
        .catch(error => console.log(error))
    }

    return (
        <Container>
            <PageTitle>
                Signup Page
            </PageTitle>
            <InputForm>
                <input onChange={nameHandler} type="text" placeholder="이름"/>
                <input onChange={emailHandler} type="email" placeholder="이메일"/>
                <input onChange={userIdHandler} type="text" placeholder="ID"/>
                <input onChange={passwordHandler} type="password" placeholder="비밀번호"/>
                <input onChange={passwordConfirmHandler} type="password" placeholder="비밀번호 확인"/>
                <input onChange={departmentHandler} type="text" placeholder="소속"/>
                <input onChange={rankHandler} type="text" placeholder="직급"/>
                <p>{ password === passwordConfirm ? "비밀번호가 일치합니다." : "비밀번호가 일치하지 않습니다."}</p>
                <LoginButton type="button" onClick={signupUser}>Signup</LoginButton>
            </InputForm>
        </Container>
    )
}

export default SignupPage

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

