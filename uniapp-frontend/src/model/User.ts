import { BaseModel } from "./BaseModel";
import { Role } from "./Role";

export interface User extends BaseModel {
    username : String;
    email : String;
    role : Role;
}