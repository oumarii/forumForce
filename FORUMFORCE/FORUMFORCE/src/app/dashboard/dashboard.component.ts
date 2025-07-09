import { Component, OnInit } from '@angular/core';
import { PieChartService } from '../services/pie-chart.service';
import * as d3 from 'd3';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  isGain: boolean = true;
  onMouseLeave(): void {
    // Logique à exécuter lorsque la souris quitte l'élément
  }
  onMouseLeaveSecondCircle(): void {
    // Logique à exécuter lorsque la souris quitte le deuxième cercle
  }
  sommeGain: number = 0;
  sommeDepense: number = 0;
  showTooltipText: string = '';
  getCircleValue(): string {
    // Logique pour obtenir la valeur du cercle (gain ou dépense)
    return this.isGain ? 'GAIN' : 'DÉPENSE';
  }

  tooltipText: string = '';
  constructor(private _pieChart: PieChartService) { }

  ngOnInit(): void {
    this.getChartData();
    this.drawChart();

  }

  getChartData() {
    this._pieChart.getSommeGain().subscribe((data: any) => {
      this.sommeGain = data;
    });

    this._pieChart.getSommeDepense().subscribe((data: any) => {
      this.sommeDepense = data;
    });
  }

  getCircleColor() {
    // Vous pouvez implémenter votre propre logique de couleur ici en fonction des valeurs de sommeGain et sommeDepense
    return 'blue'; // Exemple : retourne une couleur bleue pour les gains
  }

  showTooltip(text: string) {
    this.showTooltipText = text;
  }

  hideTooltip() {
    this.showTooltipText = '';
  }







  private radius: number = 100;
  private data = {
    expenses: 55,
    revenue: 45
  };





  private drawChart() {
    const svg = d3.select('.chart')
      .append('g')
      .attr('transform', `translate(${this.radius}, ${this.radius})`);

    const colorScale = d3.scaleOrdinal<string>()
      .domain(['expenses', 'revenue'])
      .range(['red', 'green']);

    const pie = d3.pie<any>()
      .sort(null)
      .value(d => d.value);

    const arc = d3.arc<any>()
      .innerRadius(0)
      .outerRadius(this.radius);

    const arcs = pie([{ label: 'expenses', value: this.data.expenses }, { label: 'revenue', value: this.data.revenue }]);

    svg.selectAll('path')
      .data(arcs)
      .enter()
      .append('path')
      .attr('fill', d => colorScale(d.data.label))
      .attr('d', arc)
      .on('mouseover', function (event, d) {
        const mouseEvent: MouseEvent = event as MouseEvent;

        d3.select('.tooltip')
          .style('display', 'block')
          .html(`${d.data.label}: ${d.data.value}`)
          .style('left', (mouseEvent.pageX) + 'px')
          .style('top', (mouseEvent.pageY - 28) + 'px');
      })
      .on('mouseout', function () {
        d3.select('.tooltip').style('display', 'none');
      });
  }








}
