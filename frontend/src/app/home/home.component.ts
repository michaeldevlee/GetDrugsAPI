import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  formData = []
  data = []
  formResponses:any;

  onReceivedResponses(responses) {
    console.log(responses);
    
    this.formResponses = responses;
  }

}
