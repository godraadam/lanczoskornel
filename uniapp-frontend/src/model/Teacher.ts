import { Curriculum } from "./Curriculum";
import { Role } from "./Role";
import { User } from "./User";

export interface Teacher extends User {
    curriculum : Curriculum
    role : Role.TEACHER
}