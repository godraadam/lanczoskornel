import { User } from "../model/User";

const url = "localhost:8080/api/user"

const getUserById = async (id : number)  => {
    const response = await fetch(url + `/${id}`, {
        method : 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
        },
    })
    const body : User = await response.json()
    return body
}
