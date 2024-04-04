import { Component } from '@angular/core';
import { EmailService } from '../../service/email.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent {
  data={
    to:"",
    subject:"",
    message:""
  }
  constructor(private email:EmailService, private snak:MatSnackBar){}

    doSubmitForm(){
      console.log("try to submit form");
      console.log("DATA", this.data);

      if(this.data.to=='' || this.data.subject=='' || this.data.subject==''){
        this.snak.open("Field can't be empty!!", "ok");
        return;
      }

      this.email.sendEmail(this.data).subscribe(
        Response=>{
          console.log(Response);
        },
        error=>{
          console.log(error);
        }
      )
    }
}
