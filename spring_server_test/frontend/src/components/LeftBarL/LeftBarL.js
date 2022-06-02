import React from 'react';
import { Link } from 'react-router-dom';
import './LeftBarL.css';
import im1 from '../../images/latest.png';

function LeftBarL(props) {

  const data = {
    id: props.latestProject.id,
    photo_link: props.latestProject.photo_link,
    title: props.latestProject.title,
    text: props.latestProject.text,
    desc: props.latestProject.desc,
    price: props.latestProject.price,
    prePrice: props.latestProject.prePrice,
    days: props.latestProject.days,
    category: props.latestProject.category,
    information: props.latestProject.information,
    owner: props.latestProject.owner
  }

  function handleClick() {
    props.handleClick(data);
  }

  return (
    <div className='leftl'>
      <p className='leftl__title'>Latest project</p>
      <div className='borderl'>
        <Link className='left1__link' to={`/project/${props.latestProject.id}`}  onClick={handleClick}>
          <img src={props.latestProject.photo_link} alt="" className='leftl__photo'/>
        </Link>
        <div className='leftl__info'>
          <div className='leftl__information'>
            <p className='leftl__tit'>FundFlow by AMAI team</p>
            <p className='leftl__text'>
              Crowdfunding platform based on principles of decentralization. The main thing that
              contributions are translated into cryptocurrency...
            </p>
          </div>
          <Link className='leftl__link' to="#">read more</Link>
        </div>
      </div>
    </div>
  );
}

export default LeftBarL;