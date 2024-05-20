import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DrugsService } from '../drugs.service';

@Component({
  selector: 'app-drug-form',
  templateUrl: './drug-form.component.html',
  styleUrl: './drug-form.component.css'
})
export class DrugFormComponent implements OnInit {
  form : FormGroup;
  @Input() formData = []
  @Input() responses : any
  @Output() onSubmitted = new EventEmitter<any>();

  constructor(private drugsService: DrugsService){}

  ngOnInit() {
    this.form = new FormGroup({
      moa: new FormControl('', Validators.required),
      generic_name: new FormControl('', [Validators.required, Validators.email]),
      brand_name: new FormControl('', Validators.required)
    });
  }
  onSubmit(){
    var form_values = this.form.value;
    const moa = form_values.moa;
    const generic_name = form_values.generic_name;
    const brand_name = form_values.brand_name;

    
    


    this.drugsService.getDrugs(moa, generic_name, brand_name).subscribe((data: any) => {
  
      this.onSubmitted.emit(data);
    })
    

  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
    // Handle changes to parentData
  }

  debugResponse(){
    let object = [];

    for (let index = 0; index < 30; index++) {

      const mock_response_object = {
        "moa" :  Math.random().toString(36).substring(2,7),
        "generic_name" :  Math.random().toString(36).substring(2,7),
        "brand_name" :  Math.random().toString(36).substring(2,7),
      }

      object.push(mock_response_object);
      
    }

    return object;
  }
}
