import { Assignment } from "./Assignment";
import { BaseModel } from "./BaseModel";
import { Student } from "./Student";

export interface Grade extends BaseModel {
    student : Student
    assignment : Assignment
    score : Number
}