import { Attendance } from "./Attendance";
import { Enrollment } from "./Enrollment";
import { Grade } from "./Grade";
import { Role } from "./Role";
import { User } from "./User";

export interface Student extends User {
    attendances : Attendance[]
    grades : Grade[]
    enrollments : Enrollment[]
    role : Role.STUDENT
}