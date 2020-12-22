import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ClientesEditarComponent } from './clientes-editar.component';

describe('ClientesEditarComponent', () => {
  let component: ClientesEditarComponent;
  let fixture: ComponentFixture<ClientesEditarComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientesEditarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientesEditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
