import { AttendanceStatus } from "./AttendanceStatus";
import { BaseModel } from "./BaseModel";
import { Laboratory } from "./Laboratory";
import { Student } from "./Student";

export interface Attendance extends BaseModel {
    student : Student
    laboratory : Laboratory
    status : AttendanceStatus
}