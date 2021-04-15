import { BaseModel } from "./BaseModel";
import { Enrollment } from "./Enrollment";
import { Laboratory } from "./Laboratory";

export interface Curriculum extends BaseModel {
    title : String
    laboratories : Laboratory[]
    enrollments : Enrollment[]
}