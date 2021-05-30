import axios from 'axios'
import { User } from '@/types/'

const API_ENDPOINT = 'http://localhost:3000/users';

export async function findByName(name: string) {
  return axios.get<User[]>(API_ENDPOINT, {params: {name}}).then(({data}) => data)
}

export async function findById(id: string) {
  return axios.get<User[]>(API_ENDPOINT, {params: {id}})
    .then(({data}) => {
      return data && data.length > 0 ? data[0] : null
    })
}