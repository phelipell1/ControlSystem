import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { EstoqueUpdateComponent } from './estoque-update.component';

describe('EstoqueUpdateComponent', () => {
  let component: EstoqueUpdateComponent;
  let fixture: ComponentFixture<EstoqueUpdateComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ EstoqueUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstoqueUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
