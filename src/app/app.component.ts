//import { HttpErrorResponse } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import Pusher from 'pusher-js';
//import Pusher from 'pusher-js/types/src/core/pusher';
// import { User } from './user';
// import { UserService } from './user.service';
/* interface Messages {username: string;
  message: string;
};  */
type Messages  = {username: string;
  message: string;
};


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit{

 

  
  
  // public users: User[] = []; 

  username = 'username';//should be reset by ngModel
  message  = ' ';//should be reset by ngModel
  messages: Messages[] = [];
  
  //let messages: Messages[];
  //messages!: Messages[];
  //messages!: string[];

  //messages: Messages[] = [];//array of messages
  //messages: string[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void{
    Pusher.logToConsole = true;

    const pusher = new Pusher('8b393a4526b0c1792e2b', {//118154b065358d96fe54
      cluster: 'us2'
    });
    //console.log("messages, message");
    //console.log(this.messages);
    //console.log(this.message);

    
    //does not execute ?
    const channel = pusher.subscribe('chat');
    console.log("before channel bind");
    channel.bind('message', (data: Messages) => {
      this.messages.push(data);
      console.log("data: " + data);
      console.log("messages: " + this.messages);
    });
  }

  submit(): void{
    this.http.post('http://localhost:8000/api/messages', {
      username: this.username,
      message: this.message
    }).subscribe(() => this.message = '');
  }

}

