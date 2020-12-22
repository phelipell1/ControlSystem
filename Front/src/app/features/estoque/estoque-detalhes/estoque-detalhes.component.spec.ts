import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { EstoqueDetalhesComponent } from './estoque-detalhes.component';

describe('EstoqueDetalhesComponent', () => {
  let component: EstoqueDetalhesComponent;
  let fixture: ComponentFixture<EstoqueDetalhesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ EstoqueDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstoqueDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
