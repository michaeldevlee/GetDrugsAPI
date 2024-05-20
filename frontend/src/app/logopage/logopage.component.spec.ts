import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogopageComponent } from './logopage.component';

describe('LogopageComponent', () => {
  let component: LogopageComponent;
  let fixture: ComponentFixture<LogopageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LogopageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LogopageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
