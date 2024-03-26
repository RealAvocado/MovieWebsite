import axios from 'axios'

const request = axios.create({
  baseURL: 'http://movienight.us-east-1.elasticbeanstalk.com/api'
  // baseURL: 'http://127.0.0.1:5000/api'
})

request.interceptors.request.use(config => {
  let token = window.localStorage.getItem('token') || window.sessionStorage.getItem('token')

  if (token) {
    config.headers['token'] = token
  }

  return config
}, error => {
  console.log(error)
  return Promise.reject(error)
})

request.interceptors.response.use(res => {
  if (res.data.code !== undefined && res.data.code !== 200) {
    alert(res.data.msg)
  }
  return res
}, function (error) {
  console.log(error)
  return Promise.reject(error)
})
export default request
