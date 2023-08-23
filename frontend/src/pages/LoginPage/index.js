import React from 'react'
import { styled } from 'styled-components'

const LoginPage = () => {
  return (
    <Container>
        <PageTitle>
            Log In Page
        </PageTitle>
        <InputForm>
            <InputUserId></InputUserId>
            <InputPassword></InputPassword>
            <LoginButton>Log In</LoginButton>
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

