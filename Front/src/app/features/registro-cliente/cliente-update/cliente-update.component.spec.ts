import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ClienteUpdateComponent } from './cliente-update.component';

describe('ClienteUpdateComponent', () => {
  let component: ClienteUpdateComponent;
  let fixture: ComponentFixture<ClienteUpdateComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ClienteUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClienteUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
