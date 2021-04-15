import { BaseModel } from "./BaseModel";
import { Curriculum } from "./Curriculum";
import { Student } from "./Student";

export interface Enrollment extends BaseModel {
    student : Student
    curriculum : Curriculum
}