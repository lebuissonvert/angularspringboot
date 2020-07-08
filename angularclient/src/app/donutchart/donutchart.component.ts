import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from '../service/user.service';
import { Chart } from '../model/chart';
import { UIChart } from 'primeng/primeng'

@Component({
  selector: 'app-donutchart',
  templateUrl: './donutchart.component.html',
  styleUrls: ['./donutchart.component.css']
})
export class DonutchartComponent implements OnInit {

  rewardStats: any;
  loading: boolean;

  @ViewChild("chartDonut") chartDonut: UIChart
  @ViewChild("chartPolar") chartPolar: UIChart
  @ViewChild("chartPie") chartPie: UIChart

  constructor(private userService: UserService) {
      this.rewardStats = {
          labels: ['A','B','C','D','E'],
          datasets: [
              {
                  data: [300, 50, 100, 10, 5],
                  backgroundColor: [
                      "#FF6384",
                      "#36A2EB",
                      "#FFCE56",
                      "#FF7F00"
                  ],
                  hoverBackgroundColor: [
                      "#FF6384",
                      "#36A2EB",
                      "#FFCE56",
                      "#FF7F00"
                  ]
              }]
          };
  }

  ngOnInit(): void {
    this.getCharts();
  }

  private getCharts() {
    this.loading = true;
    this.userService.getCharts().subscribe(data => {
      this.rewardStats.labels = [];
      this.rewardStats.datasets[0].data = [];
      data.forEach(el => {
        this.rewardStats.labels.push(el.reward+'');
        this.rewardStats.datasets[0].data.push(el.count);
        this.chartDonut.refresh();
        this.chartPolar.refresh();
        this.chartPie.refresh();
      });
      this.loading = false;
    });
  }

}
