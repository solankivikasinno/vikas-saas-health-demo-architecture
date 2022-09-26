/*
infrateam and application team
 */
import { AfterViewChecked, Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { CollapseDirective } from 'ngx-bootstrap/collapse';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: [
    './landing.component.scss'
  ]
})
export class LandingComponent implements OnInit, AfterViewChecked {
  isAuthenticated$: Observable<boolean>;

  constructor(
    private renderer: Renderer2,
    private router: Router,
  ) { }

  private isCollapsed = true;

  set IsCollapsed(value) {
    this.isCollapsed = value;
  }

  get IsCollapsed() {
    if (this.collapseRef) {
      // temp fix for "overflow: hidden"
      if (getComputedStyle(this.collapseRef.nativeElement).getPropertyValue('display') === 'flex') {
       this.renderer.removeStyle(this.collapseRef.nativeElement, 'overflow');
      }
    }
    return this.isCollapsed;
  }

  @ViewChild(CollapseDirective, { read: ElementRef, static: false }) collapse !: CollapseDirective;
  collapseRef;

  ngOnInit() {
  }

  ngAfterViewChecked(): void {
    this.collapseRef = this.collapse;
  }

  register() {
    this.router.navigate(['register']);
    return false;
  }

}
