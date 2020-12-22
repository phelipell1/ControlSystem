import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ClientesDetalhesComponent } from './clientes-detalhes.component';

describe('ClientesDetalhesComponent', () => {
  let component: ClientesDetalhesComponent;
  let fixture: ComponentFixture<ClientesDetalhesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientesDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientesDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
