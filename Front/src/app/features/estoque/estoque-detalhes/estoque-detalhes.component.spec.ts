import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstoqueDetalhesComponent } from './estoque-detalhes.component';

describe('EstoqueDetalhesComponent', () => {
  let component: EstoqueDetalhesComponent;
  let fixture: ComponentFixture<EstoqueDetalhesComponent>;

  beforeEach(async(() => {
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
