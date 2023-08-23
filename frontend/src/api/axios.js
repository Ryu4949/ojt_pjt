import axios from 'axios';

const instance = axios.create({
    baseURL: "http://localhost:8080",
    content_type: "application/json"
})

export default instance;