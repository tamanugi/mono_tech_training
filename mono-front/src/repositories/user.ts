import axios from 'axios'
import { User } from '@/types/'

const API_ENDPOINT = 'http://localhost:8080/users';

export async function findByName(name: string) {
  return axios.get<{users: User[]}>(API_ENDPOINT, {params: {name}}).then(({data}) => data.users)
}

export async function findById(id: string) {
  return axios.get<User>(API_ENDPOINT + `/${id}`)
    .then(({data}) => {
      return data;
    })
}

export async function postUser(name: string) {
  return axios.post(API_ENDPOINT, {name})
          .then(({data}) => console.log(data))
}

export async function updateUser(user: User) {
  return axios.patch(API_ENDPOINT + `/${user.id}`, {...user}).then(({data}) => data)
}