import React from "react";
import parse from "html-react-parser";
import videoMp4 from "../videos/explore.mp4";
import videoWebm from "../videos/explore.webm";

const HeroHomeVideo = ({ tagline, title, pathBtn, textBtn }) => (
  <section
    className="remove-padding relative view-height-100vh white-bg"
    id="home"
  >
    <div className="container">
      <div className="row">
        <div className="col-md-12 col-sm-12 col-xs-12 display-table view-height-100vh">
          <div className="v-align-middle text-left hero-text">
            <div className="white-color">
              <h2 className="font-400 cardo-font">{tagline}</h2>
              <h1 className="font-800">{title && parse(title)}</h1>
              <a
                href={pathBtn || process.env.PUBLIC_URL}
                className="btn btn-lg btn-light btn-rounded mt-20"
              >
                {textBtn || "Read More"}
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <video autoPlay muted loop controls="" className="html5-video">
      <source src={videoMp4} type="video/mp4" />
      <source src={videoWebm} type="video/webm" />
    </video>
  </section>
);

export default HeroHomeVideo;
