import axios from 'axios'

const token = "一个token";

const service = axios.create({
    baseURL: '/api',
    timeout: 80000
})

service.interceptors.request.use(
    config => {
        if(token) {
            config.headers.Authorization = token;
        }
        return config;
    },
    error => {
        Promise.reject(error);
    }
)

service.interceptors.response.use(
    response => response,

    error => {
        console.log('err' + error);
        return Promise.reject(error);
    }
)

export default service;