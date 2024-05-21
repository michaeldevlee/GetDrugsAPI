import { OnInit, isDevMode } from '@angular/core';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'druglookup';
  ngOnInit(): void {
      if (isDevMode()){
        console.log("Development!");
      } else{
        console.log("Production!");
        
      }
  }
}
